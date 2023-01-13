package one.dio.designPatternsChallenglibrayapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ZipService {

    @GetMapping("/{zip}/json/")
    Address searchZIP(@PathVariable("cep") String zip);
}
