package io.devpass.creditcard.data.http.response

import io.devpass.creditcard.domain.objects.ActionResponse


data class DefaultHttpResponse(
    val message: String,
) {

    fun toDefaultHttpResponse(): ActionResponse {
        return ActionResponse(message)
    }
}
