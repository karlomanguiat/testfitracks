import React, { Component } from 'react';
import {
    View,
    Text,
    StyleSheet,
} from 'react-native';

export default class Intake extends Component {
    render() {
        return (
            <View key={this.props.keyval} style={styles.intake}>
                <Text style={styles.intakeText}>{this.props.val.date}</Text>
                <Text style={styles.intakeText}>{this.props.val.intake}</Text>
            </View>
        );
    }
}
const styles = StyleSheet.create({
    intake: {
        position: 'relative',
        padding: 20,
        paddingRight: 100,
        borderBottomWidth:2,
        borderBottomColor: '#ededed'
    },
    intakeText: {
        paddingLeft: 20,
        borderLeftWidth: 10,
        borderLeftColor: '#E91E63'
    },
    intakeDelete: {
        position: 'absolute',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#2980b9',
        padding: 10,
        top: 10,
        bottom: 10,
        right: 10
    },
    intakeDeleteText: {
        color: 'white'
    }
});