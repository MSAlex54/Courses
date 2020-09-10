package ru.geekbrains.atm.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.atm.entities.AuthData;

//Фасад
public class AuthPolicy implements AuthService {

    @Autowired
    private BankService bankService;

    @Autowired
    private ClientService_I clientService;

    @Autowired
    private PartnerService_I partnerService;

    @Autowired
    private AdminService_I adminService;

    @Override
    public String authorize(AuthData aData) {
        if (aData.hasToken()){
            return adminService.authorize(aData);
        } else if (bankService.isClient(aData.getCardNumber())){
            return clientService.authorize(aData);
        } else if (bankService.isPartner(aData.getCardNumber())){
            return partnerService.authorize(aData);
        } else {
            return "Sorry, your Bank is not our Partner";
        }
    }
}
