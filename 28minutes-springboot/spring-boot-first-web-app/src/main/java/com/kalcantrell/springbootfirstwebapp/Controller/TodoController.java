package com.kalcantrell.springbootfirstwebapp.Controller;


import com.kalcantrell.springbootfirstwebapp.Model.Todo;
import com.kalcantrell.springbootfirstwebapp.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    private TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodosList(ModelMap model) {
        String name = getLoggedInUserName();
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public ModelAndView addTodoPage(ModelMap model) {
        return new ModelAndView("todo", "todo", new Todo(0, getLoggedInUserName(), "", new Date(), false));
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute("todo") @Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "todo";
        }
        service.addTodo(getLoggedInUserName(), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo/{id}", method = RequestMethod.POST)
    public String deleteTodo(@PathVariable int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/update-todo/{id}", method = RequestMethod.GET)
    public String showUpdateTodo(@PathVariable int id, ModelMap model) {
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="/update-todo/{id}", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(getLoggedInUserName());
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}
