package seal.SubjectService.Program;

import org.springframework.web.bind.annotation.RestController;

import seal.SubjectService.Subject.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProgramController {

    @Autowired
    private ProgramAdepter programAdepter;
    
    @RequestMapping(value="/programs", method=RequestMethod.GET)
    public ResponseEntity<List<Program>> getPrograms() {
        List<Program> programs = programAdepter.getAllProgramsDetail();
        return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
    }

    @RequestMapping(value = "/program/{program_id}/subject", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjectByProgramId(@PathVariable("program_id") String program_id){
        List<Subject> subjects = programAdepter.getAllSubjectsByProgramId(program_id);
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }
    
}