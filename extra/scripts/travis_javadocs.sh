#!/bin/bash
if [ "$TRAVIS_JDK_VERSION" = "oraclejdk8" ]; then
    git clone https://${GH_TOKEN}@github.com/LapisBlue/Javadocs .jd
    ./gradlew javadoc -x :SpongeAPI:javadoc && {
        cd .jd/
        git config user.name "Travis-CI"
        git config user.email "noreply@travis-ci.com"
        git rm -r commons
        cp -r ../build/docs/javadoc commons
        git add -A
        git commit -m "Update $(date -u +"%Y-%m-%dT%H:%M:%SZ")"
        git push origin gh-pages
    }
fi
