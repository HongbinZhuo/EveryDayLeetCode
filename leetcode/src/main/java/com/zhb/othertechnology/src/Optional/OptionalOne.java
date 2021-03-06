package com.zhb.othertechnology.src.Optional;

import java.util.Optional;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/12 16:27
 */
public class OptionalOne {
    public static void main(String[] args) {
        Optional<String> fullName=Optional.ofNullable(null);
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );


        System.out.println("///////////////////////////");
        Optional< String > firstName = Optional.of( "Tom" );
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        System.out.println();
    }
}
