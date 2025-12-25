package com.example.demo.service;

import com.example.demo.entity.*;
import java.time.LocalDate;
import java.util.*;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);
}