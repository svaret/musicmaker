package musicmaker

import grails.converters.JSON
import grails.converters.XML
import groovy.json.JsonBuilder

class ChordsController {
    def read() {
        List<ChordView> chordViews = []
        for (Chord chord : Chord.values()) {
            chordViews.add(new ChordView(chord.toString()))
        }

        render chordViews as JSON
    }
}