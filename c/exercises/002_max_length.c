#include <stdio.h>
#include <math.h>
#include <string.h>
#include <assert.h>

#define maxOf(a, b) ((a) > (b) ? a : b)

static int max_substring_by_count(char *str, int count, char **ret)
{
    int left = 0, right = 0;
    int max_occurrence = 0;
    int length = strlen(str);
    unsigned char occurrences['z' - 'a' + 1] = {0};

    for (right = 0; right < length; right++)
    {
        char c = str[right];

        while (occurrences[c - 'a'] >= count)
        {
            occurrences[str[left++] - 'a']--;
        }

        occurrences[c - 'a']++;
        max_occurrence = maxOf(max_occurrence, right - left + 1);
    }

    *ret = str + left;

    return right - left;
}

int main(int argc, char const *argv[])
{
    {
        int max;
        char *ret;
        char str[] = "abcddefghi";

        max = max_substring_by_count(str, 1, &ret);
        assert(strncmp(ret, "defghi", max) == 0);
    }

    {
        int max;
        char *ret;
        char str[] = "abcdefgh";

        max = max_substring_by_count(str, 1, &ret);
        assert(strncmp(ret, "abcdefgh", max) == 0);
    }

    {
        int max;
        char *ret;
        char str[] = "bcbbbcba";

        max = max_substring_by_count(str, 2, &ret);
        assert(strncmp(ret, "bcba", max) == 0);
    }

    {
        int max;
        char *ret;
        char str[] = "zzzzabcd";

        max = max_substring_by_count(str, 1, &ret);
        assert(strncmp(ret, "zabcd", max) == 0);
    }

    return 0;
}
