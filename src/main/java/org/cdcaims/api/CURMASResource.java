package org.cdcaims.api;

import org.cdcaims.models.CurrencyMaster;
import org.cdcaims.models.StatusMaster;
import org.cdcaims.repos.CurrencyRepository;
import org.cdcaims.repos.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
@RestController
@RequestMapping("/api/curmas")
public class CURMASResource {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    StatusRepository statusRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getAllCurrencies() {
        return new ResponseEntity<String>(currencyRepository.findAll().toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "find-by-code", method = RequestMethod.GET)
    public ResponseEntity<String> findByCurrencyCode(@RequestParam String code) {
        return new ResponseEntity<String>(currencyRepository.findAllByCurrencyCode(code).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "find-by-description", method = RequestMethod.GET)
    public ResponseEntity<String> findByCurrencyDescription(@RequestParam String description) {
        return new ResponseEntity<String>(currencyRepository.findAllByCurrencyDescription(description).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "find-by-status", method = RequestMethod.POST)
    public ResponseEntity<String> findByStatus(@RequestBody String statusStr) {
        return new ResponseEntity<String>(currencyRepository.findAllByStatus(StatusMaster.fromString(statusStr)).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "statuses", method = RequestMethod.GET)
    public ResponseEntity<String> getAllCurrencyStatuses() {
        return new ResponseEntity<String>(statusRepository.findAll().toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "add-currency", method = RequestMethod.POST)
    public ResponseEntity<String> addNewCurrency(@RequestBody String currencyStr) {
        CurrencyMaster currency = CurrencyMaster.fromString(currencyStr);
        currencyRepository.save(currency);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @RequestMapping(value = "remove-currency", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeCurrency(@RequestBody String currencyStr) {
        CurrencyMaster currency = CurrencyMaster.fromString(currencyStr);
        currencyRepository.delete(currency);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}