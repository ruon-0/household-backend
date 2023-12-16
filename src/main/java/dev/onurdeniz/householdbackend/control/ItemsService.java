package dev.onurdeniz.householdbackend.control;

import dev.onurdeniz.householdbackend.items.entity.ItemsRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Validated
@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemEntityMapper mapper;
    private final ItemsRepository repo;

    long count() {
        return repo.count();
    }

    public Collection<Item> findAll() {
        return repo.findAll()
                .stream()
                .map(mapper::map)
                .collect(toList());
    }

    public Optional<Item> findById(long id) {
        return repo.findById(id)
                .map(mapper::map);
    }

    public Item create(@Valid Item item) {
        if (item == null || item.getId() != null) {
            throw new IllegalArgumentException("item must exist without any id!");
        }
        return mapper.map(repo.save(mapper.map(item)));
    }

    public Optional<Item> update(@Valid Item item) {
        if (item == null || item.getId() == null) {
            throw new IllegalArgumentException("item must exist with an id!");
        }
        if (repo.existsById(item.getId())) {
            repo.save(mapper.map(item));
        } else {
            throw new NoSuchElementException();
        }

        return findById(item.getId());
    }

    public Optional<Item> delete(long id) {
        var item = findById(id);
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }

        return item;
    }
}

