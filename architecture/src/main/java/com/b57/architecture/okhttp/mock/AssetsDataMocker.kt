package com.b57.architecture.okhttp.mock

import android.content.res.AssetManager
import okhttp3.Request
import org.koin.core.KoinComponent
import org.koin.java.KoinJavaComponent.get
import retrofit2.http.GET
import retrofit2.http.POST
import timber.log.Timber
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Method

/**
 * Mock api response from assets
 */
class AssetsDataMocker : IDataMocker, KoinComponent {

    /**
     * key : api url
     * value : path of mock file in assets
     */
    private val mockMap = mutableMapOf<String, String>()

    /**
     * find all AssetsMock info of mockClass
     */
    override fun setupMockApi(mockClass: Class<*>) {
        mockClass.methods.forEach { method ->
            val mock = method.getAnnotation(AssetsMock::class.java)
            if (mock == null || !mock.enable || mock.dataPath.isEmpty()) {
                return@forEach
            }
            val url = getOkHttpUrl(method)
            if (url.isEmpty()) {
                Timber.tag(TAG)
                    .w("has mock annotation, but no GET or POST, method = ${method.name}")
                return@forEach
            }
            Timber.tag(TAG).d("mock = $mock, url = $url")
            mockMap[url] = mock.dataPath
        }
    }

    override fun mock(request: Request): String {
        val urlPath = request.url.toUri().path
        val mockPath = mockMap[urlPath]
        if (mockPath.isNullOrEmpty()) {
            return ""
        }
        return readAssets(mockPath)
    }

    /**
     * read assets file as mock response
     */
    private fun readAssets(mockPath: String): String {
        val assets: AssetManager = get(AssetManager::class.java)
        var reader: BufferedReader? = null
        val content = StringBuilder()
        try {
            reader = BufferedReader(InputStreamReader(assets.open(mockPath)))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                content.append(line)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            reader?.close()
        }
        return content.toString()
    }


    /**
     * get request url of retrofit method
     */
    private fun getOkHttpUrl(method: Method): String {
        val get = method.getAnnotation(GET::class.java)
        if (get != null) {
            return get.value
        }
        val post = method.getAnnotation(POST::class.java)
        if (post != null) {
            return post.value
        }
        return ""
    }


    companion object {
        private const val TAG = "AssetsDataMocker"
    }
}

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AssetsMock(
    val dataPath: String,
    val enable: Boolean = true
)