package com.zeinDev.tryservice;

import com.zeinDev.tryservice.entity.Try;
import com.zeinDev.tryservice.model.TryRequest;
import com.zeinDev.tryservice.service.TryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TryController {

    @Autowired
    private TryService service;
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('admin:perms','agency:perms','customer:perms')")
    public Try get(@PathVariable("id") String id){
        return service.getTryById(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('admin:perms','agency:perms','customer:perms')")
    public List<Try> getTries(){
        return service.getTries();
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('admin:perms','agency:perms')")
    public Try post(@RequestBody TryRequest request){
        return service.createTry(request) ;
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:perms') or @tryService.isTryOwner(authentication, #id)")
    public Try put(@PathVariable("id") String id,
                   @RequestBody String title,
                   @AuthenticationPrincipal Principal principal){
        return service.updateTry(id,title);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:perms')")
    public String delete(){
        return "DELETE:: TRY controller";
    }

    /*@PutMapping(/{id})
    @PreAuthorize("hasAuthority('admin:perms') or ")
    public Post update(@PathVariable("id") String postId) {
        return service.getUserPost(postId);}*/


}
