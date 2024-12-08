package com.bongbong.hodl.shared.locale;

import net.kyori.adventure.text.Component;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GREEN;

public interface Locale {
    Args0 HELLO_WORLD = () -> text("Hello world!", GREEN);

    interface Args0 {
        Component build();
    }

    interface Args1<A> {
        Component build(A a);
    }

    interface Args2<A, B> {
        Component build(A a, B b);
    }

    interface Args3<A, B, C> {
        Component build(A a, B b, C c);
    }
}