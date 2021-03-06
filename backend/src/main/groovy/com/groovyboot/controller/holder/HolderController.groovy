package com.groovyboot.controller.holder

import com.groovyboot.domain.holder.Holder
import com.groovyboot.service.holder.HolderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.nio.file.Path

@RestController
@RequestMapping
class HolderController {

    @Autowired
    private final HolderService holderService

    @RequestMapping(method = RequestMethod.GET)
    List<Holder> getHolderList() {
        return holderService.getHolderList()
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    Holder getHolder(@PathVariable('id') int id) {
        return holderService.getHolder(id)
    }

    @RequestMapping(method=RequestMethod.POST)
    public Holder create(@RequestBody Map holderInfo) {
        return holderService.save(holderInfo)
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "O formato da requisição é inválido.")
    public void onIllegalArgumentException(IllegalArgumentException exception) {
        println "APP -> Logando erro ${new Date()}: ${exception.message}"
    }

}
