import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity registerUser(RegisterRequest request) {
        if (repository.existsByEmail(request.email)) {
            throw new RuntimeException("Email already exists");
        }
        UserEntity user = new UserEntity(
                request.fullName,
                request.email,
                passwordEncoder.encode(request.password),
                "MONITOR"
        );
        return repository.save(user);
    }

    public UserEntity findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
