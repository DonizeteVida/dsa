#include <stdio.h>
#include <math.h>
#include <string.h>
#include <assert.h>

#define maxOf(a, b) ((a) > (b) ? a : b)

static int maximum_length_substring(char* s) {
    #define MAX_OCCURRENCES 2

    int left = 0, right = 0, max_length = 0, length = 0;

    unsigned int size = strlen(s);
    unsigned char occurrences['z' - 'a' + 1] = {0};

    for (right = 0; right < size; right++) {
        char c = s[right];
        while (occurrences[c - 'a'] >= MAX_OCCURRENCES) {
            occurrences[s[left++] - 'a']--;
            if (length > max_length) max_length = length;
            length--;
        }

        occurrences[c - 'a']++;
        length++;
    }

    if (length > max_length) max_length = length;

    return max_length;
}

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

    return right - left + 1;
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
        assert(maximum_length_substring(str) == max);
    }

    return 0;
}
