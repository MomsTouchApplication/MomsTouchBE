package com.momstouch.momstouchbe.domain.cart.api;

import com.momstouch.momstouchbe.domain.cart.application.CartService;
import com.momstouch.momstouchbe.domain.cart.dto.CartRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.momstouch.momstouchbe.domain.cart.dto.CartRequest.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartApiController {

    private final CartService cartService;

    @PostMapping("/members/{memberId}/carts")
    public ResponseEntity addCartMenu(@PathVariable Long memberId,
                                      @RequestBody CartMenuAddRequest cartMenuAddRequest) {

        cartService.addCartMenu(memberId, cartMenuAddRequest);
        return ResponseEntity.ok().build();
    }
}
