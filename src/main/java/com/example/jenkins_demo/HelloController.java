package com.example.jenkins_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "🚀 Jenkins로 자동 배포된 Spring Boot 애플리케이션입니다!\n" +
                "빌드 시간: " + java.time.LocalDateTime.now();
    }

    @GetMapping("/health")
    public String health() {
        return "✅ 애플리케이션이 정상 작동 중입니다!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "안녕하세요, " + name + "님! Jenkins CI/CD 파이프라인이 성공적으로 작동했습니다! 🎉";
    }

    @GetMapping("/build-info")
    public String buildInfo() {
        return "Build Number: " + System.getProperty("build.number", "LOCAL") + "\n" +
                "Build Time: " + System.getProperty("build.time", "Unknown") + "\n" +
                "Version: 1.0.0";
    }
}