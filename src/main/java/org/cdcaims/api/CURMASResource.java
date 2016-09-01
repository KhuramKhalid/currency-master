package org.cdcaims.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
@RestController
@RequestMapping("/api")
public class CURMASResource {

    @RequestMapping(value = "curmas", method = RequestMethod.GET)
    public ResponseEntity<String> getCurmas() {
        return new ResponseEntity<String>("values", HttpStatus.OK);
    }
}