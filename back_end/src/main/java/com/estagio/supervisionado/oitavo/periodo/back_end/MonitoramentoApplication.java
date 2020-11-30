package com.estagio.supervisionado.oitavo.periodo.back_end;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class MonitoramentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoramentoApplication.class, args);
	}

	// Descrição Swagger (OpenAPI)
	@Bean
	public OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {

		return new OpenAPI().info(new Info().title("Projeto Estágio Supervisionado API").version(appVersion).description("Projeto com objetivo de monitorar a temperatura e a umidade de um determinado refrigerador em uma clínica.").termsOfService("http://swagger.io/terms/")
		.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
