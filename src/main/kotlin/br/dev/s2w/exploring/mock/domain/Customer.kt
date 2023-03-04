package br.dev.s2w.exploring.mock.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Customer(
    val customerId: String,
    val hasPremiumIsiflixAccount: String,
    val personalInformation: PersonalInformation,
    val contactInformation: ContactInformation,
    val addressInformation: AddressInformation,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PersonalInformation(
    val fullName: String,
    val gender: String,
    val birthday: String,
    val documentNumber: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ContactInformation(
    val cellPhoneNumber: String,
    val phoneNumber: String,
    val emailAddress: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AddressInformation(
val street: String,
val number: String,
val complement: String,
val neighborhood: String,
val city: String,
val state: String,
val zipCode: String
)
