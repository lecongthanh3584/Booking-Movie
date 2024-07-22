package com.example.demo.Mapper;

import com.example.demo.DTOs.Response.BillResponse;
import com.example.demo.Entities.Bill;

import java.util.stream.Collectors;

public class BillMapper {

    public static BillResponse mapFromEntityToResponse(Bill bill) {
        if(bill == null) {
            return null;
        }

        return new BillResponse (
                bill.getBillId(),
                bill.getTotalPrice(),
                bill.getTradingCode(),
                bill.getCreateTime(),
                bill.getTicketList().stream().map(
                        TicketMapper::mapFromEntityToResponse
                ).collect(Collectors.toList()),
                bill.getBillFoodList().stream().map(
                        BillFoodMapper::mapFromEntityToResponse
                ).collect(Collectors.toList())
        );
    }
}
