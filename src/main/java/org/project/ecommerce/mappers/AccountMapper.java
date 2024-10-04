package org.project.ecommerce.mappers;

import org.mapstruct.Mapper;
import org.project.ecommerce.dtos.requests.AccountCreationRequest;
import org.project.ecommerce.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toAccount(AccountCreationRequest request);
}
