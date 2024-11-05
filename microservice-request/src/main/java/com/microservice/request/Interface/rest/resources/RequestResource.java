package com.microservice.request.Interface.rest.resources;

public record RequestResource(Long id, Long userIdFrom, Long userIdTo, String title, String description, String status, Long locationId, String issueDate) {

}
