package com.agcodes.model;

// Naming of the parameters in the request
public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email)
{

}
