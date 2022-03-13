package com.khai.mycv.data.source

import android.content.Context
import com.khai.mycv.data.common.readJsonAsset
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody

class MockClient(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val data = context.assets.readJsonAsset("data.json")

        return Response.Builder()
            .protocol(Protocol.HTTP_1_1)
            .request(chain.request())
            .code(200)
            .message("SUCCESS")
            .body(ResponseBody.create(null, data))
            .build()
    }

}