package com.khai.mycv.data.source

import android.content.Context
import android.util.Log
import com.khai.mycv.data.common.TAG
import com.khai.mycv.data.common.readJsonAsset
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.FileNotFoundException

class MockClient(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val data =
            try {
                context.assets.readJsonAsset("data.json")
            }
            catch (e: FileNotFoundException) {
                Log.d(TAG, "data file not found, using empty default JSON")
                context.assets.readJsonAsset("data.default.json")
            }

        return Response.Builder()
            .protocol(Protocol.HTTP_1_1)
            .request(chain.request())
            .code(200)
            .message("SUCCESS")
            .body(ResponseBody.create(null, data))
            .build()
    }

}