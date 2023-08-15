package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Bus;

import java.util.List;

public interface IBus {
    Bus addBus(Bus b);
    Bus updateBus(Long id ,Bus b) ;
    Bus retrieveBusById(Long id);
    List<Bus> retrieveAllBus();
    void deleteBus(Long id);
}
