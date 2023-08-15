package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Services.IBus;
import com.bezkoder.springjwt.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class BusController {
    @Autowired
    IBus ibus;
    @PostMapping("/addBus")
    public Bus addBus(@RequestBody Bus b){
        return ibus.addBus(b);

    }
    @PutMapping("/updateBus/{id}")
    public Bus updateBus(@PathVariable("id") Long id, @RequestBody Bus b)  {
        return ibus.updateBus(id,b);
    }
    @GetMapping("/getBusById/{id}")
    public Bus retrieveBusById(@PathVariable("id") Long id){
        return ibus.retrieveBusById(id);
    }
    @GetMapping("/getbus")
    public List<Bus> retrieveAllBus(){
        return ibus.retrieveAllBus();
    }
    @DeleteMapping("/deleteBus/{id}")
    public void deleteBus(@PathVariable("id") Long id){
        ibus.deleteBus(id);
    }
}
