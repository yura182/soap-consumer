package com.yura.soapconsumer.service;

import com.yura.soapconsumer.wsdl.AddUserRequest;
import com.yura.soapconsumer.wsdl.AddUserResponse;
import com.yura.soapconsumer.wsdl.DeleteUserRequest;
import com.yura.soapconsumer.wsdl.GetUserRequest;
import com.yura.soapconsumer.wsdl.GetUserResponse;
import com.yura.soapconsumer.wsdl.GetUsersRequest;
import com.yura.soapconsumer.wsdl.GetUsersResponse;
import com.yura.soapconsumer.wsdl.ObjectFactory;
import com.yura.soapconsumer.wsdl.UserDto;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

public class UserService extends WebServiceGatewaySupport {

    private static final ObjectFactory FACTORY = new ObjectFactory();

    public UserDto getUser(Integer id) {
        GetUserRequest request = FACTORY.createGetUserRequest();
        request.setId(id);

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getUser();
    }

    public UserDto addUser(UserDto userDto) {
        AddUserRequest request = FACTORY.createAddUserRequest();
        request.setUser(userDto);

        AddUserResponse response = (AddUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getUser();
    }

    public List<UserDto> findAll() {
        GetUsersRequest request = FACTORY.createGetUsersRequest();
        GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getUsers();
    }

    public void delete(Integer id) {
        DeleteUserRequest request = FACTORY.createDeleteUserRequest();
        request.setId(id);

        getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
