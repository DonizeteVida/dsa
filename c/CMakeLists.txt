cmake_minimum_required(VERSION 3.10.0)
project(c VERSION 0.1.0 LANGUAGES C)

function(add_exercise)
    add_executable(${ARGV0} exercises/${ARGV0}.c)
endfunction(add_exercise)

add_executable(c main.c)

add_exercise(001_reverse)
add_exercise(002_max_length)

