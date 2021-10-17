package com.reecegroup.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @ApiModelProperty(value = "Customer First Name", required = true)
    private String firstname;

    @ApiModelProperty(value = "Customer Last Name", required = true )
    private String lastname;

    @ApiModelProperty(value = "Customer Phone Number", required = true )
    private String phonenumber;

    @ApiModelProperty(value = "Address Book ID", required = true )
    private Long bookid;

    @JsonProperty("customer_url")
    private String customerUrl;
}
