package CBNLicenceMockPush;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mock")
public class MockController {





    @PostMapping("/pushForms")
    public ResponseEntity<?> pushNewMessages( @RequestBody MessagePushParam mpp, BindingResult result){

        FormPushing fm = new FormPushing();
        return new ResponseEntity<String>(fm.pushMessage(mpp),HttpStatus.OK);
    }

}

