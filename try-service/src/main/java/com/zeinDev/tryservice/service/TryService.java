package com.zeinDev.tryservice.service;

import com.zeinDev.tryservice.entity.Try;
import com.zeinDev.tryservice.model.TryRequest;
import com.zeinDev.tryservice.repository.TryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TryService {
    @Autowired
    private TryRepository repository;
    @Autowired
    private WebSocketService websocket;

    public Try createTry(TryRequest request){
        String id = UUID.randomUUID().toString();
        Try tryEntity = Try.builder()
                .tryId(id)
                .title(request.getTitle())
                .content(request.getContent())
                .writer(request.getWriter())
                .build();
        Try saved = repository.save(tryEntity);
        websocket.notifyFrontEnd(saved);
        //websocket.notifyUser(saved.getWriter(),saved);
        return saved;
    }
    public List<Try> getTries(){
        return repository.findAll();
    }
    public Try getTryById(String id){
        return repository.findByTryId(id);
    }
    public Try updateTry(String id,String title){
        Try entit = repository.findByTryId(id);
        entit.setTitle(title);
        Try saved = repository.save(entit);
        return  saved;
    }
    public boolean isTryOwner(Authentication authentication, String id) {
        Try tryEntity = repository.findByTryId(id);

        String owner = tryEntity.getWriter();
        String currentUser = authentication.getName();
        return currentUser.equals(owner);

    }
}
