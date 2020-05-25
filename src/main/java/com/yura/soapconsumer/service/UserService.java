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

    public UserDto getUser(Integer id) {
        GetUserRequest request = new ObjectFactory().createGetUserRequest();
        request.setId(id);

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getUser();
    }

    public UserDto addUser(UserDto userDto) {
        AddUserRequest request = new ObjectFactory().createAddUserRequest();
        request.setUser(userDto);

        AddUserResponse response = (AddUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getUser();
    }

    public List<UserDto> findAll() {
        GetUsersRequest request = new ObjectFactory().createGetUsersRequest();
        GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getUsers();
    }

    public void delete(Integer id) {
        DeleteUserRequest request = new ObjectFactory().createDeleteUserRequest();
        request.setId(id);

        getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
