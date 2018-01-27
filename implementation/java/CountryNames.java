// Takes a given country name in french and returns the name with the correct article.
// Written by Cristian Crane

public class CountryNames
{
    /**
     * Determines whether the country starts with a vowel
     * @param name the country name
     * @return true if it starts with a vowel, false otherwise
     */
    private static boolean startsWithVowel(String country)
    {
        String firstLetter = country.substring(0,1);
        return "aeiou".contains(firstLetter);
    }

    /**
     * Determines whether the country the country is plural
     * @param name the country name
     * @return true if the country is plural, false otherwise
     */
    private static boolean isPlural(String country)
    {
        return (country.equals("etats-unis") || country.equals("pays-bas")) ? true : false;
    }


    /**
     * Determines whether the country name is feminine
     * @param name the country name
     * @return true if the country is feminine, false otherwise
     */
    private static boolean isFeminine(String country)
    {
        // determine whether country is an exception to the feminine list
        String[] exceptionList = {"belize","cambodge","mexique","mozambique","zaire","zimbabwe"};
        boolean isException = false;
        for (int i = 0; i < exceptionList.length; i++)
        {
            if (exceptionList[i].equals(country))
                isException = true;
        }

        String lastLetter = country.substring(country.length()-1);

        // if the last letter of the country is e and is not in the exception list, it is feminine, else masculine
        return (lastLetter.equals("e") && !isException) ? true : false;
    }

    /**
     * Gets the name with the proper article
     * @param name the country name
     * @return the name prepended with the proper article
     */
    public String getCompleteName(String name)
    {
        String country = name.toLowerCase();
        String completeName = "";

        if (isPlural(country))
            completeName += "les " + name;

        else if (startsWithVowel(country))
            completeName += "l'" + name;

        else
        {
            if (isFeminine(country))
                completeName += "la " + name;
            else
                completeName += "le " + name;
        }

        return completeName;
    }

}
