package kr.co.hongmin.eatgo.application;

import kr.co.hongmin.eatgo.domain.MenuItem;
import kr.co.hongmin.eatgo.domain.MenuItemRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MenuItemServiceTest {

    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemsRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        menuItemService = new MenuItemService(menuItemsRepository);
    }

    @Test
    public void bulkUpdate(){
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(MenuItem.builder().name("Kimchi").build());
        menuItems.add(MenuItem.builder().id(12L).name("Gukbob").build());
        menuItems.add(MenuItem.builder().id(1004L).destroy(true).build());

        menuItemService.bulkUpdate(1L,menuItems);

        verify(menuItemsRepository,times(2)).save(any());
        verify(menuItemsRepository,times(1)).deleteById(eq(1004L));
    }
}