package io.devpass.creditcard.data.http.response

import io.devpass.creditcard.domain.objects.http.DefaultHttpMessage


data class DefaultHttpResponse(
    val message: String,
) {

    fun toDefaultHttpResponse(): DefaultHttpMessage {
        return DefaultHttpMessage(message)
    }
}
