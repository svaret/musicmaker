package musicmaker

import grails.converters.JSON
import grails.converters.XML
import groovy.json.JsonBuilder

class ChordsController {
    def show() {
        List<ChordView> chordViews = []
        for(Chord chord : Chord.values()) {
            chordViews.add(new ChordView(chord.toString()))
        }
        withFormat {
          json { render chordViews as JSON }
        }
    }
}