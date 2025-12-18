@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }
}
