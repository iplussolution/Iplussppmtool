package iplussolution.ppmtool.Web;

import iplussolution.ppmtool.Domain.MessagePushParam;
import iplussolution.ppmtool.Domain.ServiceModule;
import iplussolution.ppmtool.Services.ESBServices;
import iplussolution.ppmtool.Services.ErrorValidationService;
import iplussolution.ppmtool.Services.formMPushing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/ESB")
public class ESBController {

    @Autowired
    private ESBServices esbServices;

    @Autowired
    private ErrorValidationService errorValidationService;

    @PostMapping("")
    public ResponseEntity<?> createNewService(@Valid @RequestBody ServiceModule sm, BindingResult result){
        ResponseEntity<?> errorMap = errorValidationService.errorValidator(result);
        if(errorMap != null) return errorMap;
        ServiceModule sm2 = esbServices.saveOrUpdate(sm);
        return new ResponseEntity<ServiceModule>(sm,HttpStatus.CREATED);
    }

    @GetMapping("/{serviceID}")
    public  ResponseEntity<?> getServiceByID(@PathVariable String serviceID)
    {
        System.out.println("Am here with ID : "+serviceID);
        ServiceModule se = esbServices.findServiceByID(serviceID);
        return new ResponseEntity<ServiceModule>(se, HttpStatus.OK);
    }
    @GetMapping("/all")
    public Iterable<ServiceModule> findAllService()
    {
    return esbServices.findAllService();
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable String serviceId)
    {
        esbServices.deleteServiceByID(serviceId.toUpperCase(Locale.ROOT));

        return new ResponseEntity<String>("Service with ID '"+serviceId.toUpperCase()+"' was deleted", HttpStatus.OK);
    }

    @PostMapping("/pushForms")
    public ResponseEntity<?> pushNewMessages(@Valid @RequestBody MessagePushParam mpp, BindingResult result){
        ResponseEntity<?> errorMap = errorValidationService.errorValidator(result);
        if(errorMap != null) return errorMap;
        formMPushing fm = new formMPushing();
        return new ResponseEntity<String>(fm.pushMessage(mpp),HttpStatus.OK);
    }

}