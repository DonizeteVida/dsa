#include <stdio.h>
#include <string.h>
#include <assert.h>

static void reverse_each_substring(char* str) {
    int left = 0;

    for (int right = 0; right < strlen(str) + 1; right++)
    {
        if (str[right] == ' ' || str[right] == '\0')
        {
            int l = left;
            int r = right - 1;

            while (l < r)
            {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;

                l++;
                r--;
            }

            left = right + 1;
        }
    }
}

int main(int argc, char const *argv[])
{
    char str[] = "Let's take a LeetCode contest!";

    reverse_each_substring(str);

    assert(strcmp(str, "s'teL ekat a edoCteeL !tsetnoc") == 0);

    return 0;
}
