package com.agcodes.customer.model;

// Naming of the parameters in the request
public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email)
{

}
