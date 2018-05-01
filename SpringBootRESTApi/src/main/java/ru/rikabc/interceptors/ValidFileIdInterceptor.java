package ru.rikabc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.rikabc.models.Note;
import ru.rikabc.repositories.NoteRepository;
import ru.rikabc.services.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @Author Roman Khayrullin on 20.04.2018
 * @Version 1.0
 */
@Component
public class ValidFileIdInterceptor implements HandlerInterceptor {
    @Autowired
    NoteRepository repository;
    @Autowired
    JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] requestURI = request.getServletPath().split("/");
        String token = request.getHeader("Authorization");
        Long userId = jwtUtil.getIdFromToken(token);
        Long id;
        if (requestURI.length < 3) {
            request.setAttribute("userId", userId);
            return true;
        }
        try {
            id = new Long(requestURI[2]);
        } catch (NumberFormatException e) {
            response.sendError(NOT_FOUND.value());
            return false;
        }
        Note note = repository.findNoteById(id);
        boolean noValidUrl = note == null || !note.getUserId().equals(userId);
        if (noValidUrl) {
            response.sendError(NOT_FOUND.value());
            return false;
        }
        request.setAttribute("note", note);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
