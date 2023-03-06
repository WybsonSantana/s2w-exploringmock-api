package br.dev.s2w.exploring.mock.util.constants

object Constants {

    // Client names
    const val GET_MESSAGE_CLIENT_NAME = "get-message-client"
    const val GET_CUSTOMER_INFO_CLIENT_NAME = "get-customer-info-client"

    // Param names
    const val X_DOCUMENT_NUMBER = "document-number"
    const val X_CUSTOMER_ID = "customer-id"

    // Exception handler error messages
    const val HANDLE_BAD_REQUEST_MESSAGE = "Oops! It looks like something is wrong!"
    const val HANDLE_UNAUTHORIZED_MESSAGE = "Oops! It looks like you are not authorized to proceed!"
    const val HANDLE_FORBIDDEN_MESSAGE = "Oops! Forbidden to move forward!"
    const val HANDLE_NOT_FOUND_MESSAGE = "Oops! Nothing found here!"
    const val HANDLE_INTERNAL_SERVER_ERROR_MESSAGE = "Oops! Unable to complete your request!"


}
