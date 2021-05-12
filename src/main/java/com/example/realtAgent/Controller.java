package com.example.realtAgent;

import com.example.realtAgent.Entity.Agency;
import com.example.realtAgent.Entity.Authorization;
import com.example.realtAgent.Entity.Infohome;
import com.example.realtAgent.Entity.Specialist;
import com.example.realtAgent.Repo.AgencyRepository;
import com.example.realtAgent.Repo.AuthorizationRepository;
import com.example.realtAgent.Repo.InfohomeRepository;
import com.example.realtAgent.Repo.SpecialistRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Autowired
    private SpecialistRepository specialistRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private InfohomeRepository infohomeRepository;

    @Autowired
    private DataSource dataSource;
    private String city = "Минск";

    @GetMapping(value = "/", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
    public String minskMain(Model model){
        city = "Минск";
        model = main(model);
        return "main";
    }

    @GetMapping("/brest-region")
    public String brestMain(Model model){
        city = "Брест";
        model = main(model);
        return "main";
    }

    @GetMapping("/vitebsk-region")
    public String vitebskMain(Model model){
        city = "Витебск";
        model = main(model);
        return "main";
    }

    @GetMapping("/gomel-region")
    public String gomelMain(Model model){
        city = "Гомель";
        model = main(model);
        return "main";
    }

    @GetMapping("/grodno-region")
    public String grodnoMain(Model model){
        city = "Гродно";
        model = main(model);
        return "main";
    }

    @GetMapping("/mogilev-region")
    public String mogilevMain(Model model){
        city = "Могилев";
        model = main(model);
        return "main";
    }

    @GetMapping("/person/{idspecialist}")
    public String pagespecialist(@PathVariable int idspecialist, Model model){
        Optional<Specialist> specialists = specialistRepository.findById(idspecialist);
        Specialist specialist = specialists.get();
        specialist.setViews(specialist.getViews()+1);
        specialistRepository.deleteById(idspecialist);
        specialistRepository.save(specialist);
        String[] star1 = new String[5];
        String[] star2 = new String[5];
        String[] star3 = new String[5];
        String[] star4 = new String[5];
        {
            Arrays.fill(star1, " ");
            for (int i = 0; i < specialist.getAdvertency(); i++)
                star1[i] = " active";
            Arrays.fill(star2, " ");
            for (int i = 0; i < specialist.getCompetence(); i++)
                star2[i] = " active";
            Arrays.fill(star3, " ");
            for (int i = 0; i < specialist.getResponsibility(); i++)
                star3[i] = " active";
            Arrays.fill(star4, " ");
            for (int i = 0; i < specialist.getPunctuality(); i++)
                star4[i] = " active";
        }
        Optional<Agency> agency = agencyRepository.findById(specialist.getIdagency());
        model.addAttribute("star1", star1);
        model.addAttribute("star2", star2);
        model.addAttribute("star3", star3);
        model.addAttribute("star4", star4);
        model.addAttribute("agency", agency.get());
        model.addAttribute("specialist", specialists.get());
        model.addAttribute("gorod", city);
        return "specialist";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute Authorization authorization, @ModelAttribute String repeatpassword, @ModelAttribute String role, Model model) {
        String str = "redirect:/";
        authorization.setActive((byte)1);
        authorizationRepository.save(authorization);
        if (!role.equals("SPECIALIST")) {
            role = "USER";
            str =  "redirect:/";
        } else {
            authorization.setActive((byte)0);
            str =  "redirect:/addspecialist";
        }
        registration(authorization.getEmail(), role);
        model.addAttribute(authorization);
        model.addAttribute("repeatpassword", repeatpassword);
        model.addAttribute("role", role);
        return str;
    }

    @GetMapping("/registration")
    public String registration(Model model)
    {
        String role = "USER";
        String repeatpassword = "";
        Authorization authorization = new Authorization();
        model.addAttribute("repeatpassword", repeatpassword);
        model.addAttribute("role", role);
        model.addAttribute(authorization);
        return "registration";
    }

    @PostMapping(value = "/addflat", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.ALL_VALUE)
    public String addflat(@ModelAttribute Infohome flat, @RequestParam("image") MultipartFile file, Model model) throws IOException
    {
        String uuidFile = UUID.randomUUID().toString();
        String fileName = uuidFile + "." + file.getOriginalFilename();
        String uploadDir = "C:\\Учеба\\РИС\\realtAgent\\src\\main\\resources\\static\\img";
        FileUploadUtil.saveFile(uploadDir,fileName,file);
        flat.setPicture(fileName);
        infohomeRepository.save(flat);
        model.addAttribute(flat);
        return "redirect:/";
    }

    @GetMapping("/addflat")
    public String addflat(Model model)
    {
        Infohome flat = new Infohome();
        model.addAttribute(flat);

        return "addflat";
    }

    @PostMapping("/search")
    public String mainfilter(@ModelAttribute Infohome infohome, Model model){
        Iterable<Infohome> infohomes= infohomeRepository.findAll();
        ArrayList<Infohome> findhome = new ArrayList<Infohome>();
        for(Infohome info:infohomes)
            if(info.equals(infohome))
                findhome.add(info);
        infohomes = (Iterable<Infohome>) findhome;
        model.addAttribute(infohomes);
        return "/";
    }

    @GetMapping("/account")
    public String account()
    {
        String username = " ";
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = user.getUsername();
        Authorization auth = new Authorization();
        Iterable<Authorization> autorizationIterable = authorizationRepository.findAll();
        for(Authorization authorization:autorizationIterable)
        {
            if(authorization.getEmail().equals(username))
                auth = authorization;
        }
        if(auth.getId()==1)
            return "redirect:/confirm";
        return "redirect:/account/" + auth.getId();
    }

    @GetMapping("/account/{id}")
    public String accountpage(@PathVariable int id, Model model)
    {

        model.addAttribute(city);
        return "account";
    }

    @PostMapping(value = "/addagency", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.ALL_VALUE)
    public String addagency(@ModelAttribute Agency agency, @RequestParam("picture") MultipartFile file, Model model) throws IOException
    {
        String uuidFile = UUID.randomUUID().toString();
        String fileName = uuidFile + "." + file.getOriginalFilename();
        String uploadDir = "C:\\Учеба\\РИС\\realtAgent\\src\\main\\resources\\static\\img";
        FileUploadUtil.saveFile(uploadDir,fileName,file);
        agency.setImg("/img/"+fileName);
        agencyRepository.save(agency);
        model.addAttribute(agency);
        return "redirect:/confirm";
    }

    @GetMapping("/addagency")
    public String addagency(Model model){
        Agency agency = new Agency();
        model.addAttribute(agency);
        return "addagency";
    }

    @PostMapping(value = "/addspecialist", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.ALL_VALUE)
    public String addspecialist(@ModelAttribute Specialist specialist, @RequestParam("img") MultipartFile file, Model model) throws IOException {
        String uuidFile = UUID.randomUUID().toString();
        String fileName = uuidFile + "." + file.getOriginalFilename();
        String uploadDir = "C:\\Учеба\\РИС\\realtAgent\\src\\main\\resources\\static\\img";
        FileUploadUtil.saveFile(uploadDir,fileName,file);
        specialist.setImg("/img/"+fileName);
        specialistRepository.save(specialist);
        model.addAttribute(specialist);
        return "redirect:/";
    }

    @GetMapping("/addspecialist")
    public String addspecialist(Model model)
    {
        Specialist specialist = new Specialist();
        model.addAttribute(specialist);
        return "addspecialist";
    }

    @GetMapping("/confirm")
    public String confirmAccount(@RequestParam(value = "confirm", required = false) String confirm,@RequestParam(value = "id", required = false) String id, Model model)
    {
        Iterable<Specialist> specialists = specialistRepository.findAll();
        Iterable<Authorization> authorizationIterable = authorizationRepository.findAll();
        ArrayList<Specialist> findspecialist = new ArrayList<>();
        for(Authorization authorization:authorizationIterable) {
            if (authorization.getActive() == (byte)0)
            {
                for(Specialist specialist : specialists)
                {
                    if(authorization.getId() == specialist.getIdspecialist())
                        findspecialist.add(specialist);
                }
            }

        }
        if(confirm != null) {
            if (confirm.equals("1")) {
                Optional<Authorization> specialist = authorizationRepository.findById(Integer.parseInt(id));
                specialist.get().setActive((byte) 1);
                authorizationRepository.deleteById(Integer.parseInt(id));
                authorizationRepository.save(specialist.get());
                registration(specialist.get().getEmail(), "SPECIALIST");
            } else if (confirm.equals("0")) {
                authorizationRepository.deleteById(Integer.parseInt(id));
            }
        }
        specialists = findspecialist;
        model.addAttribute("specialists", specialists);
        return "confirm";
    }
    public void registration(String email, String role)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO roles(email, role) VALUES(?,?)";
        jdbcTemplate.update(sql, email, role);

    }

    public Model main(Model model)
    {
        Infohome infohome = new Infohome();
        model.addAttribute(infohome);
        Iterable<Specialist> specialists = specialistRepository.findAll();
        Iterable<Infohome> infohomes = infohomeRepository.findAll();
        ArrayList<Specialist> find = new ArrayList<Specialist>();
        for(Specialist specialist : specialists){
            if(specialist.getCity().equals(city) && find.size()<6)
                find.add(specialist);
        }
        specialists = find;
        model.addAttribute("specialist", specialists);
        Iterable<Agency> agencies = agencyRepository.findAll();
        ArrayList<Agency> findagency = new ArrayList<Agency>();
        for(Agency agency : agencies){
            if(agency.getCity().equals(city) && findagency.size()<6)
                findagency.add(agency);
        }
        ArrayList<Infohome> findhome = new ArrayList<Infohome>();
        for(Infohome info : infohomes){
            if(info.getCity().equals(city) && findhome.size()<8 && info.getNewflat())
                findhome.add(info);
        }
        agencies = findagency;
        infohomes = findhome;
        model.addAttribute("infohomes", infohomes);
        model.addAttribute("agency", agencies);
        model.addAttribute("gorod", city);
        return model;
    }

}
