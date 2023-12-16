package dev.onurdeniz.householdbackend.items.boundary;

import dev.onurdeniz.householdbackend.items.control.ItemsService;
import dev.onurdeniz.householdbackend.items.entity.ItemsRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemsController {
    private static final String DEFAULT_MEDIA_TYPE = MediaType.APPLICATION_JSON_VALUE;

    private final ItemsService service;
    private final ItemDtoMapper mapper;
    private final ItemsRepository itemsRepository;

    @GetMapping(produces = DEFAULT_MEDIA_TYPE)
    public Collection<ItemDto> findAll() {
        return service.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @GetMapping(value = "/{id}", produces = DEFAULT_MEDIA_TYPE)
    public ItemDto findById(final @PathVariable("id") Long id) {
        return service.findById(id)
                .stream()
                .map(mapper::map)
                .findAny()
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @PostMapping(consumes = DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ItemDto> create(final @Valid @RequestBody ItemDto itemDto) {
        final var item = mapper.map(itemDto, null);
        final var newItem = service.create(item);
        final var result = mapper.map(newItem);

        final URI locationHeader = linkTo(methodOn(ItemsController.class)
                .findById(result.getId()))
                .toUri();

        return ResponseEntity.created(locationHeader).body(result);
    }

    @PutMapping(value = "/{id}", consumes = DEFAULT_MEDIA_TYPE)
    public ResponseEntity<ItemDto> update(final @PathVariable("id") Long id,
                                           final @Valid @RequestBody ItemDto itemDto) {
        return  service.update(mapper.map(itemDto, id))
                .map(mapper::map)
//                .map(item -> mapper.map(item))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDto> delete(final @PathVariable("id") Long id) {
        return service.delete(id)
                .map(mapper::map)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    private static boolean invalidRequiredAttr(ItemDto itemDto) {
//        return null == itemDto.getItemName() || itemDto.getPrice().isNaN()
//                || null == itemDto.getDateOfPurchase().
//    }
}
