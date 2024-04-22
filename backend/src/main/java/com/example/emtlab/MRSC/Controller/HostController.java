package com.example.emtlab.MRSC.Controller;

import com.example.emtlab.MRSC.Model.Host;
import com.example.emtlab.MRSC.Service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/host")
@RequiredArgsConstructor
public class HostController {

    private final HostService hostService;

    @GetMapping("/all")
    public List<Host> findAll() {
        return hostService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id) {
        return hostService.findById(id)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseThrow();
    }

    @PostMapping("/add")
    public ResponseEntity<Host> create(@RequestParam String name, @RequestParam String surname, @RequestParam Long countryId) {
        return hostService.create(name, surname, countryId)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Host> edit(@PathVariable Long id, @RequestParam String name, @RequestParam String surname, @RequestParam Long countryId) {
        return hostService.edit(id, name, surname, countryId)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        hostService.deleteById(id);
    }
}
