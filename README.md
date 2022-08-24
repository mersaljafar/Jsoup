jsoup: Java HTML Parser
jsoup is a Java library for working with real-world HTML. It provides a very convenient API for fetching URLs and extracting and manipulating data, using the best of HTML5 DOM methods and CSS selectors.

jsoup implements the WHATWG HTML5 specification, and parses HTML to the same DOM as modern browsers do.

scrape and parse HTML from a URL, file, or string
find and extract data, using DOM traversal or CSS selectors
manipulate the HTML elements, attributes, and text
clean user-submitted content against a safe-list, to prevent XSS attacks
output tidy HTML
jsoup is designed to deal with all varieties of HTML found in the wild; from pristine and validating, to invalid tag-soup; jsoup will create a sensible parse tree.

See jsoup.org for downloads and the full API documentation.

Build Status

Example
Fetch the Wikipedia homepage, parse it to a DOM, and select the headlines from the In the News section into a list of Elements:

Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
log(doc.title());
Elements newsHeadlines = doc.select("#mp-itn b a");
for (Element headline : newsHeadlines) {
  log("%s\n\t%s", 
    headline.attr("title"), headline.absUrl("href"));
}
Online sample, full source.

Open source
jsoup is an open source project distributed under the liberal MIT license. The source code is available on GitHub.

Getting started
Download the latest jsoup jar (or add it to your Maven/Gradle build)
Read the cookbook
Enjoy!
Development and support
If you have any questions on how to use jsoup, or have ideas for future development, please get in touch via the mailing list.

If you find any issues, please file a bug after checking for duplicates.

The colophon talks about the history of and tools used to build jsoup.

Status
jsoup is in general, stable release.
